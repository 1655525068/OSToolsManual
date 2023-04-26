package entity;


import java.util.Objects;

import static Utils.Function.padLeft;

@lombok.Getter
@lombok.Setter
public
class TQuestion {
    private String percentage;
    private String correctCount;
    private String titleCount;

    public TQuestion(String cl, String right, String all) {

        this.percentage = cl;
        this.correctCount = right;
        this.titleCount = all;
    }

    @Override
    public String toString() {
        return "percentage:" + percentage + ";correctCount:" + padLeft(correctCount, 2, '0') + ";titleCount:" + padLeft(titleCount, 2, '0');
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) return true;
        if (obj instanceof TQuestion) {
            TQuestion TQuestion = (TQuestion) obj;
            return Objects.equals(TQuestion.correctCount, this.correctCount) && Objects.equals(TQuestion.titleCount, this.titleCount) && Objects.equals((TQuestion.percentage), this.percentage);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return correctCount.hashCode() * titleCount.hashCode() * percentage.hashCode();
    }


}