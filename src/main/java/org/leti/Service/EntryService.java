package org.leti.Service;

import org.leti.Domain.Entry;
import org.leti.Repo.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class EntryService {
    @Autowired
    EntryRepo entryRepo;

    public Entry addEntry(String comment) {
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Entry entry = new Entry(uuid, comment,"" + dateFormat.format( new Date() ) );
        entryRepo.save(entry);
        return entry;
    }


    public void updateComment(String comment, String entryId) {
        entryRepo.updateEntryComment(comment,entryId);
    }

    public Entry getEntryById(String entryId) {
        return entryRepo.findById(entryId).get();
    }
}
