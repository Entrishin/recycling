package org.leti.Service;

import org.leti.Domain.*;
import org.leti.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {
    @Autowired
    TransactionRepo transactionRepo;
    @Autowired
    TransactionTypeRepo transactionTypeRepo;
    @Autowired
    UnitAmountRepo unitAmountRepo;
    @Autowired
    UnitRepo unitRepo;
    @Autowired
    TxInputRepo txInputRepo;
    @Autowired
    TxOutputRepo txOutputRepo;

    public Map<Long, String> getAllTransactionTypes() {
        List<TransactionType> types = transactionTypeRepo.findAll();
        Map<Long,String> mapTypes = new HashMap<>();

        for (TransactionType type : types) {
            mapTypes.put(type.getId(),type.getTitle());
        }
        return mapTypes;
    }

    public Map<Long, String> getAllAmountTypes() {
        List<UnitAmount> all = unitAmountRepo.findAll();
        Map<Long,String> map = new HashMap<>();

        for (UnitAmount type : all) {
            map.put(type.getId(),type.getTitle());
        }

        return map;
    }

    public Map<Long, String> getAllUnits() {
        List<Unit> all = unitRepo.findAll();
        Map<Long,String> map = new HashMap<>();

        for (Unit type : all) {
            map.put(type.getId(),type.getTitle());
        }

        return map;
    }


    public Transaction addTransaction(String transType, String debet, String credit, String amount, String amountType, String unit, Entry entry) {
        Transaction transaction = new Transaction();
        transaction.setEntry(entry);
        transaction.setTransactionTypeId(transactionTypeRepo.findByTitle(transType).getId());
        transaction.setAmountId(unitAmountRepo.findByTitle(amountType).getId());
        transaction.setTimestamp(new Date().getTime());
        transaction.setUnitId(unitRepo.findByTitle(unit).getId());

        txInputRepo.save(new TxInput(Long.parseLong(debet), transaction));
        txOutputRepo.save(new TxOutput(Long.parseLong(credit), transaction));

        return transaction;
    }
}
