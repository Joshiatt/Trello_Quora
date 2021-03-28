package com.upgrad.quora.service.entity;

        import org.apache.commons.lang3.builder.EqualsBuilder;
        import org.apache.commons.lang3.builder.HashCodeBuilder;
        import org.apache.commons.lang3.builder.ToStringBuilder;
        import org.apache.commons.lang3.builder.ToStringStyle;
        import org.hibernate.annotations.OnDelete;
        import org.hibernate.annotations.OnDeleteAction;

        import javax.persistence.*;
        import javax.validation.constraints.NotNull;
        import javax.validation.constraints.Size;
        import java.time.ZonedDateTime;

//@Entity annotation defines that a class can be mapped to a table. And that is it, it is just a marker, like for example Serializable interface
@Entity
//The @Table annotation allows you to specify the details of the table that will be used to persist the entity in the database
@Table(name = "answer")
@NamedQueries({
        @NamedQuery(name = "getAnswerById", query = "select a from AnswerEntity a where a.uuid=:uuid"),
        @NamedQuery(
                name = "getAllAnswersToQuestion",
                query = "select a from AnswerEntity a where a.questionEntity.uuid = :uuid")
})
public class AnswerEntity {
    //@Id annotation marks a field as a primary key field. When a primary key field is defined the primary key value is automatically injected into that field by ObjectDB
    @Id
    @Column(name = "id")
    //The @GeneratedValue annotation specifies that the primary key is automatically allocated by ObjectDB. Automatic value generation is discussed in detail in the Generated Values section
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uuid")
    @Size(max = 200)
    //@NotNull annotation is a variable (like fields, local variables, and parameters) cannot should not hold null value
    @NotNull
    private String uuid;

    @Column(name = "ans")
    @Size(max = 255)
    @NotNull
    private String answer;

    @Column(name = "date")
    @NotNull
    private ZonedDateTime date;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "question_id")
    private QuestionEntity questionEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public QuestionEntity getQuestionEntity() {
        return questionEntity;
    }

    public void setQuestionEntity(QuestionEntity questionEntity) {
        this.questionEntity = questionEntity;
    }

    @Override
    public boolean equals(Object obj) {
        return new EqualsBuilder().append(this, obj).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this).hashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}