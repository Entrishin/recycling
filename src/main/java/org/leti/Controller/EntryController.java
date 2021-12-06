package org.leti.Controller;

import org.leti.Domain.Entry;
import org.leti.Domain.Transaction;
import org.leti.Service.EntryService;
import org.leti.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/entry")
public class EntryController {
    @Autowired
    EntryService entryService;
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public String entry(Map<String, Object> model) {
        model.put("transactionTypes", transactionService.getAllTransactionTypes());
        model.put("amountTypes", transactionService.getAllAmountTypes());
        model.put("units", transactionService.getAllUnits());
        Entry entry = entryService.addEntry("");
        model.put("entryId", entry.getId());
        model.put("transactions", transactionService.getAllTransactionsByEntryId(entry.getId()));
        String comm = "";
        comm += entryService.getEntryById(entry.getId()).getComment();
        model.put("comment",comm);

        return "entryEdit";
    }

    @PostMapping
    public String addTransaction(@RequestParam(name = "transtype") String transType,
                                 @RequestParam(name = "debet", defaultValue = "") String debet,
                                 @RequestParam(name = "credit", defaultValue = "") String credit,
                                 @RequestParam(name = "savebutton") String savebutton,
                                 @RequestParam(name = "comment", defaultValue = "") String comment,
                                 @RequestParam(name = "amount", defaultValue = "") String amount,
                                 @RequestParam(name = "amountType") String amountType,
                                 @RequestParam(name = "unit") String unit,
                                 @RequestParam(name = "entryId") String entryId,
                                 Map<String, Object> model) {
        //сохранить транзакцию в базе
        if (savebutton.equals("savetransaction")) {
            Transaction transaction = transactionService.addTransaction(transType, debet, credit, amount, amountType, unit, entryId);
        }
        model.put("transactions", transactionService.getAllTransactionsByEntryId(entryId));

        model.put("entryId", entryId);
        model.put("transactionTypes", transactionService.getAllTransactionTypes());
        model.put("amountTypes", transactionService.getAllAmountTypes());
        model.put("units", transactionService.getAllUnits());
        entryService.updateComment(comment,entryId);
        String comm = "";
        comm += entryService.getEntryById(entryId).getComment();
        model.put("comment", comment);
        return "entryEdit";
    }

    @GetMapping("/{entryId}")
    public String entryInfo(@PathVariable String entryId, Model model) {
        model.addAttribute("entryId", entryId);
        model.addAttribute("transactions", transactionService.getAllTransactionsByEntryId(entryId));
        model.addAttribute("comment",entryService.getEntryById(entryId).getComment());
        return "entryInfo";
    }
}
