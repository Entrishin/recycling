package org.leti.Service;

import org.leti.Domain.Entry;
import org.leti.Repo.EntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EntryService {
    @Autowired
    EntryRepo entryRepo;

    public Entry addEntry(String comment) {
        final String uuid = UUID.randomUUID().toString().replace("-", "");
        Entry entry = new Entry(uuid, comment);
        entryRepo.save(entry);
        return entry;
    }
}
