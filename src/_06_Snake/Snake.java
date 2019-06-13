package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);

		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		//1. add a new SnakeSegment object to the snake
		int xfactor = 0;
		int yfactor = 0;
		if (currentDirection.equals(Direction.UP)) {
			yfactor = -1;
		}
		else if (currentDirection.equals(Direction.DOWN)) {
			yfactor = 1;
		}
		else if (currentDirection.equals(Direction.RIGHT)) {
			xfactor = -1;
		}
		else {
			xfactor = 1;
		}
		snake.add(new SnakeSegment(new Location(snake.get(snake.size()-1).getLocation().x+xfactor, 
				snake.get(snake.size()-1).getLocation().y+yfactor), BODY_SIZE));
	}

	public Location getHeadLocation() {
		//2. return the location of the snake's head
		return head.getLocation();
	}

	public void update() {
		//1. use a switch statement to check on the currentDirection
		//   of the snake and calculate its next x and y position.
		int x;
		int y;
		
		switch (currentDirection) {
		
		case LEFT:
			x = getHeadLocation().x - 1;
			y = getHeadLocation().y;
			break;
		case UP:
			x = getHeadLocation().x;
			y = getHeadLocation().y + 1;
			break;
		case RIGHT:
			x = getHeadLocation().x + 1;
			y = getHeadLocation().y;
			break;
		case DOWN:
			x = getHeadLocation().x;
			y = getHeadLocation().y - 1;
			break;
		default:
			x = getHeadLocation().x;
			y = getHeadLocation().y + 1;
		}

		//2. Iterate through the SnakeSegments in reverse order
		for (int i = snake.size()-1; i>0; i--) {
			snake.get(i).setLocation(snake.get(i-1).getLocation());
		}
		//2a. Update each snake segment to the location of the segment 
		//    in front of it.
		
		
		//3. set the location of the head to the new location calculated in step 1
		head.setLocation(new Location(x, y));

		//4. set canMove to true
		canMove = true;
	}

	public void setDirection(Direction d) {
		//1. set the current direction equal to the passed in Direction only if canMove is true.
		//   set canMove equal to false.
		//   make sure the snake cannot completely reverse directions.
		if (canMove) {
			if (currentDirection == Direction.RIGHT && !(d == Direction.LEFT)) {
				currentDirection = d;
			}
			else if (currentDirection == Direction.LEFT && !(d == Direction.RIGHT)) {
				currentDirection = d;
			}
			else if (currentDirection == Direction.UP && !(d == Direction.DOWN)) {
				currentDirection = d;
			}
			else if (currentDirection == Direction.DOWN && !(d == Direction.UP)) {
				currentDirection = d;
			}
		}
		
	}

	public void reset(Location loc) {
		int x = (int) Math.random() * 15;
		int y = (int) Math.random() * 12;
		//1. clear the snake
		snake.clear();
		//2. set the location of the head
		head.setLocation(new Location(x, y));
		//3. add the head to the snake
		snake.add(head);
	}

	public boolean isOutOfBounds() {
		//1. complete the method so it returns true if the head of the snake is outside of the window
		//   and false otherwise
		if (head.getLocation().x > 14 || head.getLocation().x < 0) {
			return true;
		}
		if (head.getLocation().y > 11 || head.getLocation().y < 0) {
			return true;
		}
		return false;
	}
	
	public boolean isHeadCollidingWithBody() {
		//1. complete the method so it returns true if the head is located
		//   in the same location as any other body segment
		for (int i=1; i<snake.size()-1; i++) {
			if (head.getLocation().equals(snake.get(i).getLocation())) {
				return true;
			}
		}
		return false;
	}

	public boolean isLocationOnSnake(Location loc) {
		//1. complete the method so it returns true if the passed in
		//   location is located on the snake
		for (int i=0; i<snake.size()-1; i++) {
			if (loc.equals(snake.get(i).getLocation())) {
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
