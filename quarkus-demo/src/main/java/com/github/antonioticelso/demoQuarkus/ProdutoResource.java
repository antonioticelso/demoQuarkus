package com.github.antonioticelso.demoQuarkus;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.MediaType;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> buscarTodosProdutos() {

        return Produto.listAll();
    }

    @POST
    @Transactional
    public void buscarTodosProdutos(final CadastroProdutoDTO dto) {
        final Produto p = new Produto();
        p.nome = dto.nome;
        p.valor = dto.valor;
        p.persist();

//        Produto.listAll();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void buscarTodosProdutos(@PathParam("id") final Long id, final CadastroProdutoDTO dto) {
        final Optional<Produto> produtoOp = Produto.findByIdOptional(id);

        if(produtoOp.isPresent()) {
            final Produto produto = produtoOp.get();
            produto.nome = dto.nome;
            produto.valor = dto.valor;
            produto.persist();
    
        } else {
            throw new NotFoundException();
        }

    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void buscarTodosProdutos(@PathParam("id") final Long id) {
        final Optional<Produto> produtoOp = Produto.findByIdOptional(id);

        produtoOp.ifPresentOrElse(Produto::delete, () -> {
            throw new NotFoundException();
        });

    }


}


