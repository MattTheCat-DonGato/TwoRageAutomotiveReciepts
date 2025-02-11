/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Matthew Rodriguez
 */
public class Email
{
    //main email set-up
    private String host;
    private String port;
    private String mailFrom;
    private String password;

    // message info
    private String toAddress;
    private String subject;
    private String message;

    // attachments
    private String[] attachFiles;

    // Empty Constructor
    public Email()
    {
        
    }
    
    // Parameter Constructor
    public Email(String host, String port, String mailFrom, String password, String toAddress, String subject, String message, String[] attachFiles)
    {
        this.host = host;
        this.port = port;
        this.mailFrom = mailFrom;
        this.password = password;
        this.toAddress = toAddress;
        this.subject = subject;
        this.message = message;
        this.attachFiles = attachFiles;
    }

    /**
     * @return the host
     */
    public String getHost()
    {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host)
    {
        this.host = host;
    }

    /**
     * @return the port
     */
    public String getPort()
    {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port)
    {
        this.port = port;
    }

    /**
     * @return the mailFrom
     */
    public String getMailFrom()
    {
        return mailFrom;
    }

    /**
     * @param mailFrom the mailFrom to set
     */
    public void setMailFrom(String mailFrom)
    {
        this.mailFrom = mailFrom;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the toAddress
     */
    public String getToAddress()
    {
        return toAddress;
    }

    /**
     * @param toAddress the toAddress to set
     */
    public void setToAddress(String toAddress)
    {
        this.toAddress = toAddress;
    }

    /**
     * @return the subject
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    /**
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * @return the attachFiles
     */
    public String[] getAttachFiles()
    {
        return attachFiles;
    }

    /**
     * @param attachFiles the attachFiles to set
     */
    public void setAttachFiles(String[] attachFiles)
    {
        this.attachFiles = attachFiles;
    }
}