package com.company;

import com.company.models.User;
import com.company.repository.UsersRepository;
import com.company.repository.UsersRepositoryFileWriterImpl;
import com.company.util.IdGeneratorFileBasedImpl;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepositoryFileWriterImpl("users.txt", IdGeneratorFileBasedImpl.generator());
        User marsel = new User(usersRepository.getNewUserId(),"Марсель", "Сидиков", LocalDate.of(1994, 2, 2));
        User marsel1 = new User(usersRepository.getNewUserId(),"Александр ", "Пушкин", LocalDate.of(1799, 6, 6));
        User marsel2 = new User(usersRepository.getNewUserId(),"Петр", "Петров", LocalDate.of(1889, 2, 2));
        usersRepository.save(marsel);
        usersRepository.save(marsel1);
        usersRepository.save(marsel2);
        usersRepository.delete(4);
        usersRepository.update(new User(10,"Достоевский","Федор", LocalDate.of(1821,11,11)));
        User findUs = usersRepository.find(9);
        System.out.println(findUs.getId() + " " + findUs.getFirstName() + " " + findUs.getLastName() + " " + findUs.getBirthDate());

    }
}
