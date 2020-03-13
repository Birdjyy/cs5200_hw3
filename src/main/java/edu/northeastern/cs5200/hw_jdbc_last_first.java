package edu.northeastern.cs5200;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.daos.*;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ldap.PagedResultsControl;
import java.sql.Date;
import java.util.Collection;


public class hw_jdbc_last_first {
    /*public static void main(String[] args){
        //findAllDevelopers();
        //new_page();
        createDeveloper();
        createWebsite();
        createPage();
        createWidget();
        update();
    }*/

    /*public static Collection<Developer> findAllDevelopers() {
        DeveloperDao developerDao = new DeveloperDao();
        System.out.println(developerDao.findAllDevelopers().size());
        return developerDao.findAllDevelopers();
    }*/

    public void createDeveloper() {
        DeveloperDao developerDao = new DeveloperDao();
        developerDao.createDeveloper(new Developer("4321rewq", 12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com"));
        developerDao.createDeveloper(new Developer("5432trew", 23, "Bob", "Marley", "bob", "bob", "bob@marley.com"));
        developerDao.createDeveloper(new Developer("6543ytre", 34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com"));

        PersonDao personDao = new PersonDao();
//        personDao.createPerson(new Person(12, "Alice", "Wonder", "alice", "alice", "alice@wonder.com"));
//        personDao.createPerson(new Person(23, "Bob", "Marley", "bob", "bob", "bob@marley.com"));
//        personDao.createPerson(new Person(34, "Charles", "Garcia", "charlie", "charlie", "chuch@garcia.com"));
        personDao.createPerson(new Person(45, "Dan", "Martin", "dan", "dan", "dan@martin.com"));
        personDao.createPerson(new Person(56, "Ed", "Karaz", "ed", "ed", "ed@kar.com"));

        UserDao userDao = new UserDao();
        userDao.createUser(new User("7654fda", 45, "Dan", "Martin", "dan", "dan", "dan@martin.com"));
        userDao.createUser(new User("5678dfgh", 56, "Ed", "Karaz", "ed", "ed", "ed@kar.com"));

    }

    public void createWebsite() {
        WebsiteDao websiteDao = new WebsiteDao();
        java.util.Date date = new java.util.Date();
        java.sql.Date d = new java.sql.Date(date.getTime());
        websiteDao.createWebsiteForDeveloper(12, new Website(123, "Facebook", "an online social media and social networking service", d, d, 1234123, 12));
        websiteDao.createWebsiteForDeveloper(23, new Website(123, "Facebook", "an online social media and social networking service", d, d, 1234123, 23));
        websiteDao.createWebsiteForDeveloper(34, new Website(123, "Facebook", "an online social media and social networking service", d, d, 1234123, 34));
        websiteDao.createWebsiteForDeveloper(23, new Website(234, "Twitter", "an online news and social networking service", d, d, 4321543, 23));
        websiteDao.createWebsiteForDeveloper(34, new Website(234, "Twitter", "an online news and social networking service", d, d, 4321543, 34));
        websiteDao.createWebsiteForDeveloper(12, new Website(234, "Twitter", "an online news and social networking service", d, d, 4321543, 12));
        websiteDao.createWebsiteForDeveloper(12, new Website(345, "Wikipedia", "a free online encyclopedia", d, d, 3456654, 12));
        websiteDao.createWebsiteForDeveloper(23, new Website(345, "Wikipedia", "a free online encyclopedia", d, d, 3456654, 23));
        websiteDao.createWebsiteForDeveloper(34, new Website(345, "Wikipedia", "a free online encyclopedia", d, d, 3456654, 34));
        websiteDao.createWebsiteForDeveloper(34, new Website(456, "CNN", "an American basic cable and satellite television news channel", d, d, 6543345, 34));
        websiteDao.createWebsiteForDeveloper(12, new Website(456, "CNN", "an American basic cable and satellite television news channel", d, d, 6543345, 12));
        websiteDao.createWebsiteForDeveloper(23, new Website(456, "CNN", "an American basic cable and satellite television news channel", d, d, 6543345, 23));
        websiteDao.createWebsiteForDeveloper(23, new Website(567, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", d, d, 5433455, 23));
        websiteDao.createWebsiteForDeveloper(12, new Website(567, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", d, d, 5433455, 12));
        websiteDao.createWebsiteForDeveloper(34, new Website(567, "CNET", "an American media website that publishes reviews, news, articles, blogs, podcasts and videos on technology and consumer electronics", d, d, 5433455, 34));
        websiteDao.createWebsiteForDeveloper(34, new Website(678, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics", d, d, 4322345, 34));
        websiteDao.createWebsiteForDeveloper(12, new Website(678, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics", d, d, 4322345, 12));
        websiteDao.createWebsiteForDeveloper(23, new Website(678, "Gizmodo", "a design, technology, science and science fiction website that also writes articles on politics", d, d, 4322345, 23));

        WebsiteRoleDao websiteRoleDao = new WebsiteRoleDao();
        websiteRoleDao.createWebRole(new WebRole(12,123, 1));
        websiteRoleDao.createWebRole(new WebRole(12,234, 3));
        websiteRoleDao.createWebRole(new WebRole(12,345, 2));
        websiteRoleDao.createWebRole(new WebRole(12,456, 1));
        websiteRoleDao.createWebRole(new WebRole(12,567, 3));
        websiteRoleDao.createWebRole(new WebRole(12, 789, 2));
        websiteRoleDao.createWebRole(new WebRole(23,123,2));
        websiteRoleDao.createWebRole(new WebRole(23,234,1));
        websiteRoleDao.createWebRole(new WebRole(23,345,3));
        websiteRoleDao.createWebRole(new WebRole(23,456,2));
        websiteRoleDao.createWebRole(new WebRole(23,567,1));
        websiteRoleDao.createWebRole(new WebRole(23,789,3));
        websiteRoleDao.createWebRole(new WebRole(34,123,3));
        websiteRoleDao.createWebRole(new WebRole(34,234,2));
        websiteRoleDao.createWebRole(new WebRole(34,345,1));
        websiteRoleDao.createWebRole(new WebRole(34,456,3));
        websiteRoleDao.createWebRole(new WebRole(34,567,2));
        websiteRoleDao.createWebRole(new WebRole(34,789,1));
    }

    public void createPage() {
        PageDao pageDao = new PageDao();
        java.util.Date date = new java.util.Date();
        java.sql.Date d = new java.sql.Date(date.getTime());
        pageDao.createPageForWebsite(567, new Page(123, "Home", "Landing page", d, d, 123434, 567));
        pageDao.createPageForWebsite(678, new Page(234, "About", "Website description", d, d, 234545, 678));
        pageDao.createPageForWebsite(345, new Page(345, "Contact", "Addresses, phones, and contact info", d, d, 345656, 345));
        pageDao.createPageForWebsite(456, new Page(456, "Preferences", "Where users can configure their preferences", d, d, 456776, 456));
        pageDao.createPageForWebsite(567, new Page(567, "Profile", "Users can configure their personal information", d, d, 567878, 567));

        PageRoleDao pageRoleDao = new PageRoleDao();
        pageRoleDao.createPageRole(new PageRole(12, 123, 2));
        pageRoleDao.createPageRole(new PageRole(12, 234, 5));
        pageRoleDao.createPageRole(new PageRole(12, 345, 4));
        pageRoleDao.createPageRole(new PageRole(12, 456, 2));
        pageRoleDao.createPageRole(new PageRole(12, 567, 5));
        pageRoleDao.createPageRole(new PageRole(23, 123, 4));
        pageRoleDao.createPageRole(new PageRole(23, 234, 2));
        pageRoleDao.createPageRole(new PageRole(23, 345, 5));
        pageRoleDao.createPageRole(new PageRole(23, 456, 4));
        pageRoleDao.createPageRole(new PageRole(23, 567, 2));
        pageRoleDao.createPageRole(new PageRole(34, 123, 5));
        pageRoleDao.createPageRole(new PageRole(34, 234, 4));
        pageRoleDao.createPageRole(new PageRole(34, 345, 2));
        pageRoleDao.createPageRole(new PageRole(34, 456, 5));
        pageRoleDao.createPageRole(new PageRole(34, 567, 4));
    }

    public void createWidget(){
        WidgetDao widgetDao = new WidgetDao();
        widgetDao.createWidgetForPage(123, new Widget("head123", "Welcome", 0, 123));
        widgetDao.createWidgetForPage(234, new Widget("post234", "<p>Lorem</p>", 0, 234));
        widgetDao.createWidgetForPage(345, new Widget("head345", "Hi", 1, 345));
        widgetDao.createWidgetForPage(345, new Widget("intro456", "<h1>Hi</h1>", 2, 345));
        widgetDao.createWidgetForPage(345, new Widget("image345", 50, 100, 3, 345));
        widgetDao.createWidgetForPage(456, new Widget("video456", 400, 300, 0, 456));

        widgetDao.createImageWidgetForWieget(5, "/img/567.png");
        widgetDao.createYoutubeWidgetForWieget(6, "https://youtu.be/h67VX51QXiQ");
    }

    public void update() {
        DeveloperDao developerDao = new DeveloperDao();
        developerDao.updatephone(34, "333-444-5555");

        WidgetDao widgetDao = new WidgetDao();
        widgetDao.updateWidget(3, new Widget("head345", "Hi", 3, 345));
        widgetDao.updateWidget(5, new Widget("image345", 50, 100, 1, 345));

        PageDao pageDao = new PageDao();
        java.util.Date date = new java.util.Date();
        java.sql.Date d = new java.sql.Date(date.getTime());
        pageDao.updatePage(123, new Page(123, "CNET - Home", "Landing page", d, d, 123434, 567));
        pageDao.updatePage(567, new Page(567, "CNET - Profile", "Users can configure their personal information", d, d, 567878, 567));

        PageRoleDao pageRoleDao = new PageRoleDao();
        pageRoleDao.updatePageRole(new PageRole(34, 123, 4));
        pageRoleDao.updatePageRole(new PageRole(23, 123, 5));
    }

    public void delete() {
        DeveloperDao developerDao = new DeveloperDao();
        developerDao.deleteAdress(12, true);

        WidgetDao widgetDao = new WidgetDao();
        widgetDao.deleteLastWidget(345);

        PageDao pageDao = new PageDao();
        pageDao.deleteLastPage(345);

        WebsiteDao websiteDao = new WebsiteDao();
        websiteDao.deleteWebsite(567);
        WebsiteRoleDao websiteRoleDao = new WebsiteRoleDao();
        websiteRoleDao.deleteWebRole(567);
        WebPriviledgeDao webPriviledgeDao = new WebPriviledgeDao();
        webPriviledgeDao.deleteWebRole(567);
    }
    /*
    public static void createWebsite() {
        WebsiteDao websiteDao = new WebsiteDao();
        websiteDao.createWebsiteForDeveloper(new Website());
    }
    public static void new_page() {
        Date date = new Date(2242020);
        Page pa1 = new Page(123, "Home", "Landing page", date, date, 123434);

        PageDao pageI = new PageDao();
        pageI.createPageForWebsite(567, pa1);
    }*/
}
