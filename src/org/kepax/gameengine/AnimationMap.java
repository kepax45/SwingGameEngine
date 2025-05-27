package org.kepax.gameengine;
import java.util.HashMap;

public class AnimationMap extends HashMap<String, AnimationCollection> {
	private static final AnimationMap instance = new AnimationMap();
	private AnimationMap() {
		super();
	}
	public static AnimationCollection getAnimationCollection(String collectionName) {
		return instance.get(collectionName);
	}
	public static int putAnimationCollection(String collectionName, AnimationCollection collection) {
		if(getAnimationCollection(collectionName) == null) {
			instance.put(collectionName, collection);
			return 0;
		} else {
			return -1;
		}
	}
	public static void eraseAnimationCollection(String collectionName) {
		instance.remove(collectionName);
	}
	public static AnimationMap getInstance() {
        return instance;
    }
}
