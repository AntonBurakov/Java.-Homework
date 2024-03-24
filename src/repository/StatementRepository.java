package repository;

import model.Statement;

import java.util.ArrayList;
import java.util.List;

public class StatementRepository {
    private List<Statement> statements = new ArrayList<>();

    public void add(Statement statement){
        statements.add(statement);
    }

    public List<Statement> getStatements(){
        return statements;
    }

    public void setStatements(List<Statement> statements){
        this.statements = statements;
    }
}