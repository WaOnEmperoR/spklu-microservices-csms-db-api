package com.fastcharging.csmsdbapi.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fastcharging.csmsdbapi.model.OutputWrapper;
import com.fastcharging.csmsdbapi.model.TransactionMonitor;
import com.fastcharging.csmsdbapi.repository.TransactionMonitorRepository;

@Service
public class TransactionMonitorServiceImpl implements TransactionMonitorService {

	@Autowired
	private TransactionMonitorRepository transactionMonitorRepository;

	@Override
	public OutputWrapper findAllTransactionMonitor(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<Map<String, Object>> pagedResult = transactionMonitorRepository.findAllTransactionMonitor(paging);

		OutputWrapper ow = new OutputWrapper(pagedResult.getContent(), pagedResult.getNumber(), pagedResult.getSize(),
				pagedResult.getNumberOfElements(), pagedResult.getTotalPages(), pagedResult.getTotalElements());

		return ow;
	}

	@Override
	public List<TransactionMonitor> findTransactionMonitorByIdTag(String idTag, int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);

		List<TransactionMonitor> transactionMonitors = transactionMonitorRepository
				.findByIdTagOrderByStopTimestampDesc(idTag, paging);

		return transactionMonitors;
	}

	@Override
	public List<TransactionMonitor> findTransactionMonitorByTransactionPk(int transactionPk) {

		List<TransactionMonitor> transactionMonitors2 = transactionMonitorRepository.findByTransactionPk(transactionPk);

		return transactionMonitors2;
	}

}
