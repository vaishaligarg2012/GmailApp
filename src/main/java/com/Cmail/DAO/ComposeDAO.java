package com.Cmail.DAO;

import java.util.List;

import com.Cmail.Model.ComposeMail;

public interface ComposeDAO {
         public  boolean createCompose(ComposeMail user, String email);
         public List<ComposeMail> details(String email);
         public  List<ComposeMail> viewAllSentMail(String Email);
         public List<ComposeMail> viewAllMails();
}
