package com.example.dylan.masterflow.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Andrew Scott", "http://agora.cs.wcu.edu/~ascott/"));
        addItem(new DummyItem("2", "William Kreahling", "http://agora.cs.wcu.edu/~wck/"));
        addItem(new DummyItem("3", "Scott Barlowe", "http://agora.cs.wcu.edu/~sbarlowe/"));
        addItem(new DummyItem("4", "Mark Holliday", "http://agora.cs.wcu.edu/~holliday/"));
        addItem(new DummyItem("5", "Dylan Foster", "https://www.youtube.com/watch?v=ZZ5LpwO-An4"));
        addItem(new DummyItem("6", "Jeffery Dahmer", "https://www.youtube.com/watch?v=K79ZYH54jBY"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     * Responsible for creating individual items in the list.
     */
    public static class DummyItem {
        public String id;
        public String item_name;
        public String url;

        public DummyItem(String id, String item_name, String url) {
            this.id = id;
            this.item_name = item_name;
            this.url = url;
        }

        @Override
        public String toString() {
            return item_name;
        }
    }
}
