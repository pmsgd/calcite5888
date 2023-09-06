package calcite.reproducer

import org.apache.calcite.sql.type.SqlTypeName


sealed class Column(
    open val name: String,
) {
    open class Basic(
        override val name: String,
        open val type: SqlTypeName
    ) : Column(name)
}
