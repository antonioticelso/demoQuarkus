package com.github.antonioticelso.demoQuarkus;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.github.database.rider.cdi.api.DBRider;
import com.github.database.rider.core.api.dataset.DataSet;

@DBRider
@QuarkusTest
@QuarkusTestResource(DatabaseLifecycle.class)
public class ProdutoTest {

    @Test
    @DataSet("produtos1.yml")
    public void listProdutoEndpoint() {

        Assert.assertEquals(1, Produto.count());

    }

}


