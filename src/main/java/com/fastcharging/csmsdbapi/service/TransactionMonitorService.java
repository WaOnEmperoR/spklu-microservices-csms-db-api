package com.fastcharging.csmsdbapi.service;

import java.util.List;
import java.util.Optional;
import com.fastcharging.csmsdbapi.model.OutputWrapper;
import com.fastcharging.csmsdbapi.model.TransactionMonitor;

public interface TransactionMonitorService {
	OutputWrapper findAllTransactionMonitor(int pageNo, int pageSize);
	
	List<TransactionMonitor> findTransactionMonitorByIdTag(String idTag, int pageNo, int pageSize);

	List<TransactionMonitor> findTransactionMonitorByTransactionPk(int transactionPk);
	
}
