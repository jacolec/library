package com.kodilla.library.copy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CopyService {

    @Autowired
    private CopyRepository copyRepository;

    public Copy saveCopy(final Copy copy) {
        return copyRepository.save(copy);
    }

    public void deleteCopy(final Long copyId) {
        copyRepository.deleteById(copyId);
    }

    public List<Copy> getCopies() {
        return (List<Copy>) copyRepository.findAll();
    }

    public Copy getCopy(Long copyId) {
        return copyRepository.findById(copyId).get();
    }


}
