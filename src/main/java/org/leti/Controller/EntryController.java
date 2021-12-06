package org.leti.Controller;

import org.leti.Domain.Entry;
import org.leti.Domain.Transaction;
import org.leti.Service.EntryService;
import org.leti.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class EntryController {
    @Autowired
    EntryService entryService;
    @Autowired
    TransactionService transactionService;

    @GetMapping("/entry")
    public String entry(Map<String,Object> model) {
        model.put("transactionTypes", transactionService.getAllTransactionTypes());
        model.put("amountTypes", transactionService.getAllAmountTypes());
        model.put("units", transactionService.getAllUnits());

        putContentText(model);

        return "entryEdit";
    }

    @PostMapping("/entry")
    public String addTransaction(@RequestParam(name="transtype") String transType,
                                 @RequestParam(name="debet") String debet,
                                 @RequestParam(name="credit") String credit,
                                 @RequestParam(name="savebutton") String savebutton,
                                 @RequestParam(name="comment", defaultValue = "") String comment,
                                 @RequestParam(name="amount") String amount,
                                 @RequestParam(name="amountType") String amountType,
                                 @RequestParam(name="unit") String unit,
                                 Map<String,Object> model) {
        //сохранить транзакцию в базе
        Entry entry = entryService.addEntry(comment);

        transactionService.addTransaction(transType,debet,credit,savebutton,amount,amountType,unit,entry);



        return "entryEdit";
    }


    //метод для наполнения страницы русским текстом (если наполнять в файлах .ftlh ломается кодировка)
    private void putContentText(Map<String, Object> model) {
        model.put("transactionType", "Тип транзакции");
        model.put("from","Со счета: ");
        model.put("to","На счет: ");
        model.put("close","Закрыть");
        model.put("openModalWindow","Добавить транзакцию");
        model.put("transactionCreation","Создание транзакции");
        model.put("saveChanges","Сохранить");
        model.put("main_text","Создание проводки");
        model.put("comment","Комментарий к проводке");
        model.put("amount","Количество");
        model.put("unit","Актив");
        model.put("amountType","Размерность");
    }
}
