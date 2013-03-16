package org.csgames.ai.client;

import static org.junit.Assert.*;

import java.util.List;

import org.csgames.ai.client.Util.Point2D;
import org.junit.Before;
import org.junit.Test;

public class UtilTest {

	private String[][] map = {{"H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H"}, {"H", "1"," "," "," ", "W", "W", "W", "W"," ", "W", "W"," ", "W", "W"," ", "W", "W", "W", "W"," "," "," ", "3", "H"}, {"H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"}, {"H"," "," ", "W", "W"," "," ", "W", "W"," ", "W"," "," "," ", "W"," ", "W", "W"," "," ", "W", "W"," "," ", "H"}, {"H"," ", "H", "W", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H", "W", "H"," ", "H"}, {"H"," "," "," ", "W"," ", "W"," ", "W"," ", "W", "W"," ", "W", "W"," ", "W"," ", "W"," ", "W"," "," "," ", "H"}, {"H"," ", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H"," ", "H"}, {"H"," ", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "H"}, {"H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"}, {"H"," "," "," "," ", "W"," "," ", "W", "W"," ", "W"," ", "W"," ", "W", "W"," "," ", "W"," "," "," "," ", "H"}, {"H", "W", "H", "W", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H", "W", "H", "W", "H"}, {"H"," "," ", "W", "W"," ", "W", "W", "W"," ", "W"," "," "," ", "W"," ", "W", "W", "W"," ", "W", "W"," "," ", "H"}, {"H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"}, {"H"," ", "W"," "," ", "W"," "," "," ", "W"," ", "W"," ", "W"," ", "W"," "," "," ", "W"," "," ", "W"," ", "H"}, {"H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"}, {"H", "W"," ", "W"," ", "W"," "," "," ", "W", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "W"," ", "W", "H"}, {"H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"}, {"H", "W"," ", "W"," ", "W"," "," "," ", "W", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "W"," ", "W", "H"}, {"H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"}, {"H"," ", "W"," "," ", "W"," "," "," ", "W"," ", "W"," ", "W"," ", "W"," "," "," ", "W"," "," ", "W"," ", "H"}, {"H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"}, {"H"," "," ", "W", "W"," ", "W", "W", "W"," ", "W"," "," "," ", "W"," ", "W", "W", "W"," ", "W", "W"," "," ", "H"}, {"H", "W", "H", "W", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H", "W", "H", "W", "H"}, {"H"," "," "," "," ", "W"," "," ", "W", "W"," ", "W"," ", "W"," ", "W", "W"," "," ", "W"," "," "," "," ", "H"}, {"H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"}, {"H"," ", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "W"," "," "," ", "W", "W"," "," "," ", "W"," ", "H"}, {"H"," ", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H", "W", "H", "W", "H"," ", "H"," ", "H"}, {"H"," "," "," ", "W"," ", "W"," ", "W"," ", "W", "W"," ", "W", "W"," ", "W"," ", "W"," ", "W"," "," "," ", "H"}, {"H"," ", "H", "W", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H", "W", "H"," ", "H"}, {"H"," "," ", "W", "W"," "," ", "W", "W"," ", "W"," "," "," ", "W"," ", "W", "W"," "," ", "W", "W"," "," ", "H"}, {"H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H"," ", "H", "W", "H"," ", "H"," ", "H"}, {"H", "Y"," "," "," ", "W", "W", "W", "W"," ", "W", "W"," ", "W", "W"," ", "W", "W", "W", "W"," "," "," ", "4", "H"}, {"H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H", "H"}};
	private Util util;
	
	@Before
	public void before(){
		map = new String[4][4];
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				map[i][j] = "H";
		
		map[2][2] = "B";
		
		util = new Util();
		util.updateMap(map);
	}
	
	@Test
	public void testSearch(){
		List<Point2D> bombList = util.search(0, 0, 5, Util.BOMB);
		
		assertTrue(bombList.size() == 1);
		
		List<Point2D> hardWList = util.search(0, 0, 5, Util.HARD_WALL);
		
		assertTrue(hardWList.size() == 15);
		
	}

}
