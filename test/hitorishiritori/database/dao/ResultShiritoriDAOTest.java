/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hitorishiritori.database.dao;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sywatanabe
 */
public class ResultShiritoriDAOTest {
    
    public ResultShiritoriDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of select method, of class ResultShiritoriDAO.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        String word = "あい";
        int mode_flg = 1;
        int expResultCnt = 0;
        ArrayList<String> result = ResultShiritoriDAO.select(word, mode_flg);
        result.forEach(tmp -> {System.out.println(tmp);});
        assertEquals(expResultCnt, result.size());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of selectTop method, of class ResultShiritoriDAO.
     */
    @Test
    public void testSelectTop() {
        System.out.println("selectTop");
        long limit = 10;
        int mode_flg = 0;
        ArrayList<String> expResult = null;
        ArrayList<String> result = ResultShiritoriDAO.selectTop(limit, mode_flg);
        result.forEach(word -> {System.out.println(word);});
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class ResultShiritoriDAO.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String word = "こけ";
        int mode_flg = 1;
        int expResult = 1;
        int result = ResultShiritoriDAO.insert(word, mode_flg);
        ResultShiritoriDAO.select(word, mode_flg).forEach( w -> { System.out.println(w); });
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAll method, of class ResultShiritoriDAO.
     */
    @Test
    public void testDeleteAll() {
        System.out.println("deleteAll");
        int expResult = 0;
        int result = ResultShiritoriDAO.deleteAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of delte method, of class ResultShiritoriDAO.
     */
    @Test
    public void testDelte() {
        System.out.println("delte");
        int mode_flg = 1;
        int expResult = 0;
        int result = ResultShiritoriDAO.delte(mode_flg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
