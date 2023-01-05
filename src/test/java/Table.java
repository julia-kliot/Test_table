import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Table {
    WebDriver wd;

    @BeforeMethod
    public void start(){
        wd = new ChromeDriver();
        wd.get("https://www.w3schools.com/html/html_tables.asp");
        wd.manage().window().maximize();

    }

    @Test
    public void  tableTest(){
        // проверить правда ли в таблице 4 строки

        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        //wd.findElements(By.xpath("//tr"));
        Assert.assertEquals(rows.size(),4);

        // правда ли что последння строка сожержит строку Mexico
        WebElement lastRow = wd.findElement(By.cssSelector("tr:last-child"));
        //wd.findElements(By.xpath("//tr[last()]"));
        String text = lastRow.getText();
        System.out.println(text);
        //   "Poland Chine Mexico" contains "Mexico"
        Assert.assertTrue(text.contains("Mexico"));
// правда ли что последняя ячейка сожержит строку Mexico
        WebElement lastCell = wd.findElement(By.cssSelector("tr:last-child td:last-child"));
        //wd.findElement(By.xpath("//tr[last()]//td[last()]"));
        String str = lastCell.getText();
        boolean res =str.contains("Mexico");
        Assert.assertTrue(str.contains("Mexico"));
        Assert.assertTrue(res);


        //print numbers of columns
        List<WebElement> columns = wd.findElements(By.cssSelector("tr th"));
        //wd.findElements(By.xpath("//tr/th"));
        System.out.println("Print numbers of last columns -->" + columns.size());
        System.out.println("*********");

        //print rows 3
        List<WebElement> row3 = wd.findElements(By.cssSelector("tr:nth-child(3) td"));
        //wd.findElements(By.xpath("//tr[3]//td"));
        System.out.println("Row 3 --->" + row3.size());

        for (WebElement el : row3) {
            System.out.println(el.getText());
        }
        for (int i = 0; i < row3.size(); i++) {
            System.out.println(rows.get(i).getText());
        }

        //print lastColumns

        List<WebElement> lastColumns = wd.findElements(By.cssSelector("td:last-child"));
        //wd.findElements(By.xpath("//td[last()]"));
        for (WebElement el :
                lastColumns) {
            System.out.println(el.getText());
        }

        //print Maria Anders
        System.out.println(wd.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(2)")).getText());
        //wd.findElement(By.xpath("//tr[2]//td[2]"));
        //wd.findElement(By.xpath("//td[text()='Maria Anders']"));

        //get row 4
        WebElement el = wd.findElement(By.cssSelector("tr:nth-child(4)"));
        //wd.findElement(By.xpath("//tr[4]"));
        String texts = el.getText();
        System.out.println(text);
        Assert.assertEquals(texts, "Centro comercial Moctezuma Francisco Chang Mexico");
        Assert.assertTrue(text.contains("Francisco Chang"));

        String text2 = wd.findElement(By.cssSelector("tr:nth-child(4) td:nth-child(2)")).getText();
        // wd.findElement(By.xpath("//tr[4]//td[2]"));
        Assert.assertEquals(text2, "Francisco Chang");
        Assert.assertEquals(wd.findElement(By.cssSelector("tr:nth-child(4) td:nth-child(2)")).getText(), "Francisco Chang");


    }
   @AfterMethod
           public void stop(){

        wd.close();
        wd.quit();

    }
}
