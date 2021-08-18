package io.github.bucket1572.factorize.plugin.machine_configs

import io.github.bucket1572.factorize.plugin.machines.MachineType
import net.kyori.adventure.inventory.Book
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.Style
import net.kyori.adventure.text.format.TextColor
import org.bukkit.inventory.Recipe
import org.bukkit.inventory.meta.BookMeta

sealed class ConfigBook(
        private val machineType: MachineType, private val info: HashMap<ConfigInfoTag, String>, val recipe: Recipe
    ) {
    // TODO: 2021-08-19 ConfigBook 완성 및 자동 작업대 개발 
    abstract fun registerRecipe();

    fun setConfig(configInfoTag: ConfigInfoTag, content: String) {
        info[configInfoTag] = content
    }

    fun exportConfig(): Book {
        // 설정 책 제목과 저자
        val configTitle = Component.text("${machineType.title} 설정", Style.style(
            TextColor.fromHexString("#FFFFFF")
        ))
        val configAuthor = Component.text("Configuration")

        // 설정 책 구성
        val configExport = Book.builder()
        configExport.title(configTitle)
        configExport.author(configAuthor)

        // 설정 요약
        val configContents = buildString {
            info.forEach { (infoTag, content) ->
                append("${infoTag.tagName}: $content\n")
            }
            deleteCharAt(length - 1)
        }

        configExport.addPage(Component.text(configContents))

        return configExport.build()
    }
}