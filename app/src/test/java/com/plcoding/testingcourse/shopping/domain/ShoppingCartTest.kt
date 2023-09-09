package com.plcoding.testingcourse.shopping.domain

import assertk.assertFailure
import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotEqualTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource


internal class ShoppingCartTest {

    private lateinit var cart: ShoppingCart


    @BeforeEach
    fun setUp() {
        cart = ShoppingCart()
    }

    @ParameterizedTest
    @CsvSource(
        "3,15.0",
        "5,20.0",
        "0,0.0",
        "20,100.0",
    )
    fun `Add multiple products, total sum is correct`(quantity: Int) {
        val product = Product(
            1,
            "Roshan",
            5.0
        )
        cart.addProduct(product, quantity)

        assertThat(cart.getTotalCost()).isEqualTo(quantity * 5.0)
    }

    @RepeatedTest(10)
    fun `Add product with negative quantity throws exception`() {
        val product = Product(
            1,
            "Roshan",
            5.0
        )

        assertFailure {
            cart.addProduct(product, -2)
        }

    }

    @Test
    fun `add invalid product id, is product invalid`() {
        val product = Product(
            1234,
            "Roshan",
            5.0
        )

        cart.addProduct(product, 4)

        assertThat(cart.getTotalCost()).isEqualTo(0.0)
    }

}