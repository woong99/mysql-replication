package potatowonong.onemasteronereplica.global.config.db

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource
import org.springframework.transaction.support.TransactionSynchronizationManager

class ReplicationRoutingDataSource : AbstractRoutingDataSource() {

    override fun determineCurrentLookupKey(): Any? {
        val isReadOnly = TransactionSynchronizationManager.isCurrentTransactionReadOnly()

        return if (isReadOnly) {
            DataSourceType.REPLICA
        } else {
            DataSourceType.MASTER
        }
    }
}