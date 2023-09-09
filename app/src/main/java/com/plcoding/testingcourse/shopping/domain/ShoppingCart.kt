package com.plcoding.testingcourse.shopping.domain


class ShoppingCart {


    private val validListIds =  listOf(1, 2, 3, 4, 5)
    private val items = mutableListOf<Product>()

    fun addProduct(product: Product, quantity: Int) {

        if(isProductValid(product)) {
            if(quantity < 0) {
                throw IllegalArgumentException("Quantity can't be negative")
            }
            repeat(quantity) {
                items.add(product)
            }
        }

    }

    private fun isProductValid(product: Product): Boolean {
        return validListIds.contains(product.id)
    }

    fun getTotalCost(): Double {
        return items.sumOf { it.price }
    }
}