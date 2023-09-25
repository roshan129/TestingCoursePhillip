package com.plcoding.testingcourse.shopping.domain

import com.plcoding.testingcourse.shopping.domain.Product

interface ShoppingCartCache {
    fun saveCart(items: List<Product>)
    fun loadCart(): List<Product>
    fun clearCart()
}