package com.company.repository;
import com.company.util.IdGenerator;
import com.company.models.User;


import java.io.*;
import java.time.LocalDate;

public class UsersRepositoryFileWriterImpl implements UsersRepository {

    private FileWriter writer;
    private String fileName;
    private IdGenerator idGenerator;
    private String line;
    private String outputLine;


    public UsersRepositoryFileWriterImpl(String fileName, IdGenerator idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }

    @Override
    public int getNewUserId(){
        return idGenerator.getNewId();
    }
    @Override
    public User find(int id) {

        File sourceFile = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            while ((line = reader.readLine()) != null) {
                line = reader.readLine();
                if (Integer.parseInt(line.split(" ")[0]) == id) {
                    return new User(
                            id,
                            line.split(" ")[1],
                            line.split(" ")[2],
                            LocalDate.of(Integer.parseInt(line.split(" ")[3].split("-")[0]),
                                    Integer.parseInt(line.split(" ")[3].split("-")[1]),
                                    Integer.parseInt(line.split(" ")[3].split("-")[2]))
                    );


                }
            }
            reader.close();
            return null;
        }

        catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void delete(int id) {
        File sourceFile = new File(fileName);
        File outputFile = new File("tmp.txt");
        try {
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            while ((line = reader.readLine()) != null) {
                if (Integer.parseInt(line.split(" ")[0]) != id) {
                    writer.write(line);
                    writer.newLine();

                } else {System.out.println("Удален пользователь "+line);}
            }
            reader.close();
            writer.close();
            sourceFile.delete();
            outputFile.renameTo(sourceFile);

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public void save(User user) {
        try {
            writer = new FileWriter(fileName, true);
            writer.write(user.getId()
                    + " " + user.getFirstName()
                    + " " + user.getLastName()
                    + " " + user.getBirthDate().toString()
                    + "\n");
            writer.close();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }

    @Override
    public void update(User user) {

        File sourceFile = new File(fileName);
        File outputFile = new File("tmp.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            while ((line = reader.readLine()) != null) {
                if (Integer.parseInt(line.split(" ")[0]) == user.getId()){
                writer.write(user.getId() + " "
                        + user.getFirstName() + " "
                        + user.getLastName() + " "
                        + user.getBirthDate().toString() + "\n");
            }else{
                writer.write(line + "\n");
            }
            }
            reader.close();
            writer.close();
            sourceFile.delete();
            outputFile.renameTo(sourceFile);

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

    }
}