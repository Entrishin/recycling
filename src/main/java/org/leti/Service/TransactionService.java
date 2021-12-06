package org.leti.Service;

import org.leti.Domain.*;
import org.leti.Repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
    EntryRepo entryRepo;

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


    public Transaction addTransaction(String transType, String debet, String credit, String amount, String amountType, String unit, String entryId) {
        Transaction transaction = new Transaction();
        transaction.setEntry(entryRepo.findById(entryId).get());
        transaction.setTransactionTypeId(transactionTypeRepo.findByTitle(transType).getId());
        transaction.setAmountId(unitAmountRepo.findByTitle(amountType).getId());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        transaction.setTimestamp(("" + dateFormat.format( new Date() ) ));
        transaction.setUnitId(unitRepo.findByTitle(unit).getId());
        transaction.setAccountFrom(credit);
        transaction.setAccountTo(debet);
        transaction.setAmount(amount.isEmpty()?0.0:Double.parseDouble(amount));
        transaction.setAmountTitle(amountType);
        transaction.setTransactionTypeTitle(transType);
        transaction.setUnitTitle(unit);
        transactionRepo.save(transaction);
        return transaction;
    }

    public List<Transaction> getAllTransactionsByEntryId(String entryId) {
        return transactionRepo.findAllByEntryId(entryId);
    }

    public String getTransactionTypeById(Long id) {
        return transactionTypeRepo.findById(id).get().getTitle();
    }
    public String getAmountTypeById(Long id) {
        return unitAmountRepo.findById(id).get().getTitle();
    }
    public String getUnitById(Long id) {
        return unitRepo.findById(id).get().getTitle();
    }



}
