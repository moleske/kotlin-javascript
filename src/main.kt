import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlinx.html.js.onClickFunction
import org.w3c.dom.Element
import kotlin.browser.document

val restaurantOne = Restaurant(
        name = "My Restaurant",
        cuisineType = "The Best Stuff",
        websiteUrl = "yourfoodissubpar.com",
        rating = 90
)

fun main(args: Array<String>) {
    val root = document.getElementById("root")

    val restaurantList = mutableListOf(restaurantOne, restaurantOne, restaurantOne, restaurantOne, restaurantOne, restaurantOne)

    render(root!!, restaurantList)
}


private fun render(root: Element, restaurantList: MutableList<Restaurant>) {
    root.appendChild(
            document.create.div {
                h1 { +"Restaurant List" }
                button {
                    +"Add Restaurant"
                    onClickFunction = {
                        root.removeChild(root.firstChild!!)
                        restaurantList.add(restaurantOne)
                        render(root, restaurantList)
                    }
                }
                table {
                    tr {
                        th { +"Name" }
                        th { +"Cuisine Type" }
                        th { +"Website" }
                        th { +"Rating" }
                    }
                    restaurantList.forEach {
                        style = "text-align:center;"
                        displayRestaurant(it)
                    }
                }
            })
}

private fun TABLE.displayRestaurant(restaurantOne: Restaurant) {
    tr {
        td { +restaurantOne.name }
        td { +restaurantOne.cuisineType }
        td { +restaurantOne.websiteUrl }
        td { +restaurantOne.rating.toString() }
    }
}
