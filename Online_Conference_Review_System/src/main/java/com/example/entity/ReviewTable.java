package com.example.entity;

//INSERT INTO reviews VALUES ('carls.bill@conf.com', 12001, 7, 7, 7, 7, 6, 'average paper', 'average paper');
public class ReviewTable {
  private String revemail;
  private long paperid;
  private int techmerit;
  private int readability;
  private int originality;
  private int relavance;
  private int overallrecomm;
  private String commentforcommittee;
  private String commentforauthor;

  public ReviewTable(String revemail, long paperid, int techmerit, int readability, int originality, int relavance, int overallrecomm, String commentforcommittee, String commentforauthor) {
      this.revemail = revemail;
      this.paperid = paperid;
      this.techmerit = techmerit;
      this.readability = readability;
      this.originality = originality;
      this.relavance = relavance;
      this.overallrecomm = overallrecomm;
      this.commentforcommittee = commentforcommittee;
      this.commentforauthor = commentforauthor;
  }

  public String getRevemail() {
      return revemail;
  }

  public long getPaperid() {
      return paperid;
  }

  public int getTechmerit() {
      return techmerit;
  }

  public int getReadability() {
      return readability;
  }

  public int getOriginality() {
      return originality;
  }

  public int getRelavance() {
      return relavance;
  }

  public int getOverallrecomm() {
      return overallrecomm;
  }

  public String getCommentforcommittee() {
      return commentforcommittee;
  }

  public String getCommentforauthor() {
      return commentforauthor;
  }
}
