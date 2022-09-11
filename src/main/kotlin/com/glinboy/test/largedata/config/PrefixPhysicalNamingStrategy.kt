package com.glinboy.test.largedata.config

import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment
import java.util.*

class PrefixPhysicalNamingStrategy : PhysicalNamingStrategyStandardImpl() {
    companion object {
        const val TABLE_NAME_PREFIX = "ld_%s"
    }

    private val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()

    override fun toPhysicalTableName(name: Identifier, context: JdbcEnvironment?): Identifier? {
        val newIdentifier = Identifier(TABLE_NAME_PREFIX.format(name.text.camelToSnakeCase()), name.isQuoted)
        return super.toPhysicalTableName(newIdentifier, context)
    }

    private fun String.camelToSnakeCase(): String {
        return camelRegex.replace(this) {
            "_${it.value}"
        }.lowercase(Locale.getDefault())
    }
}
