package io.github.bucket1572.factorize.plugin.machine.autominer

import io.github.bucket1572.factorize.plugin.FactorizePlugin
import net.kyori.adventure.inventory.Book
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.Style
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.Recipe
import org.bukkit.inventory.ShapedRecipe
import org.bukkit.inventory.meta.BookMeta
import org.bukkit.plugin.Plugin

object AutoMinerFactory {
    val configBook: Book
    val recipe: Recipe

    init {
        val configBookBuilder = Book.builder()
        configBookBuilder.title(Component.text(
            "자동 채굴기",
            Style.style(
                TextColor.fromCSSHexString("#FFFFFF"),
            )
        ))
        configBookBuilder.author(
            Component.text(
                "구성"
            )
        )
        configBookBuilder.addPage(
            Component.text(
                "범위: 5 * 5\n필터: "
            )
        )

        configBook = configBookBuilder.build()

        val configBookItem = ItemStack(Material.BOOK)
        

        recipe = ShapedRecipe(NamespacedKey.fromString("Factorize")!!,)
    }
}