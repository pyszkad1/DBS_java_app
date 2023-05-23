package dbs;

import jakarta.persistence.*;

@Entity
@Table(name = "T_Result")
public class TResult {
    @EmbeddedId
    private TResultId id;

    @Column(name = "contract", length = 10, nullable = false)
    private String contract;

    @Column(name = "declarer", length = 1, nullable = false)
    private String declarer;

    @Column(name = "contract_result", length = 3, nullable = false)
    private String contractResult;

    @Column(name = "points", nullable = false)
    private Integer points;

    // Default constructor
    public TResult() {
    }

    // Parameterized constructor
    public TResult(TResultId id, String contract, String declarer, String contractResult, Integer points) {
        this.id = id;
        this.contract = contract;
        this.declarer = declarer;
        this.contractResult = contractResult;
        this.points = points;
    }

    // Getters and setters

    public TResultId getId() {
        return id;
    }

    public void setId(TResultId id) {
        this.id = id;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getDeclarer() {
        return declarer;
    }

    public void setDeclarer(String declarer) {
        this.declarer = declarer;
    }

    public String getContractResult() {
        return contractResult;
    }

    public void setContractResult(String contractResult) {
        this.contractResult = contractResult;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "TResult{" +
                "id=" + id +
                ", contract='" + contract + '\'' +
                ", declarer='" + declarer + '\'' +
                ", contractResult='" + contractResult + '\'' +
                ", points=" + points +
                '}';
    }
}

