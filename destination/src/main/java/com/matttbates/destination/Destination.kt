package com.matttbates.destination

abstract class Destination(val route: String){
    fun routeWithArgs(vararg args: Any?): String{
        val formatRoute = route.replace("\\{[a-zA-Z0-9]*\\}".toRegex(), "%s")
        val arguments = args.map {
            it?.toString()?.trim()?.replace("+", " ")?.takeIf { arg -> arg.isNotEmpty() }
        }.toTypedArray()
        return formatRoute.format(*arguments)
    }
}