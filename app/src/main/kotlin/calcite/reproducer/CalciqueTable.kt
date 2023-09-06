package calcite.reproducer

import org.apache.calcite.rel.type.RelDataType
import org.apache.calcite.rel.type.RelDataTypeFactory
import org.apache.calcite.rel.type.RelProtoDataType
import org.apache.calcite.schema.impl.AbstractTable

class CalciqueTable(val columns: List<Column>) : AbstractTable() {

    private val columnsWithTypes = RelProtoDataType {
        it.builder().apply {
            columns.forEach { column ->
                when (column) {
                    is Column.Basic ->
                        this.add(column.name, column.type).nullable(true)
                }
            }
        }.build()
    }

    override fun getRowType(typeFactory: RelDataTypeFactory): RelDataType = columnsWithTypes.apply(typeFactory)
}