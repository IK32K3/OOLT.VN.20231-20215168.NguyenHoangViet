package hust.soict.hedspi.aims.screen.manager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.*;
import hust.soict.hedspi.aims.*;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import javafx.collections.ObservableList;


public class StoreManagerScreen extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cart store;
	
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update store");
		JMenuItem BookMenuItem = new JMenuItem("Add Book");
		smUpdateStore.add(BookMenuItem);

		JMenuItem CDMenuItem = new JMenuItem("Add CD");
		smUpdateStore.add(CDMenuItem);
		
		JMenuItem DVDMenuItem = new JMenuItem("Add DVD");
	
		smUpdateStore.add(DVDMenuItem);
		
		MenuItemListener menuItemListener = new MenuItemListener();
		BookMenuItem.addActionListener(menuItemListener);
		CDMenuItem.addActionListener(menuItemListener);
		DVDMenuItem.addActionListener(menuItemListener);
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Store"));
		menu.add(new JMenuItem("View Cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100,50));
		cart.setMaximumSize(new Dimension(100,50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		
		ObservableList<Media> mediaInStore = store.getList();
		for(int i=0;i<9;i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public class MediaStore extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public MediaStore(Media media) {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel("" + media.getCost() + " $");
			cost.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			if(media instanceof Playable) {
				JButton playButton = new JButton("Play");
				container.add(playButton);
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	
	public StoreManagerScreen(Cart store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024,768);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] agrs) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Harry Potter and the Philosopher's stone", 3f);
		Store.all.addMedia(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Harry Potter and the Chamber of Secrets", 3.5f);
		Store.all.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry Potter and the Prisoner of Azkaban", 5f);
		Store.all.addMedia(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter and the Goblet of Fire", 4.5f);
		Store.all.addMedia(dvd4);
		Track track1 = new Track("Hello", 180);
		Track track2 = new Track("Hi", 240);
		Track track3 = new Track("Fetch the Bolt Cutters", 210);
		CompactDisc cd1 = new CompactDisc("Fetch the Bolt Cutters", 10.39f);
		cd1.addTrack(track3);
		Store.all.addMedia(cd1);
		CompactDisc cd2 = new CompactDisc("Future Nostalgia", 9.6f);
		cd2.addTrack(track1);
		cd2.addTrack(track2);
		Store.all.addMedia(cd2);
		Book b1 = new Book("The Hunger Games", 5.5f);
		Store.all.addMedia(b1);
		Book b2 = new Book("Catching Fire", 4.9f);
		Store.all.addMedia(b2);
		Book b3 = new Book("Mocking Jay", 5.1f);
		Store.all.addMedia(b3);
		new StoreManagerScreen(Store.all);
	}
	
	 class MenuItemListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	            String cmd = e.getActionCommand();
	            if(cmd.equals("Add Book")) new AddBookToStoreScreen();
	            else if(cmd.equals("Add CD")) new AddCDToStoreScreen();
	            else new AddDVDToStoreScreen();
	        }
	 }
}
