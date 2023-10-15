package fr.pandaguerrier.conodia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.bukkit.ChatColor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Config {
  private final File file;
  
  private JSONObject json;
  
  private final JSONParser parser = new JSONParser();
  
  private final HashMap<String, Object> defaults = new HashMap<>();
  
  public Config(File file) {
    this.file = file;
    try {
      json = (JSONObject) new JSONParser().parse(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
  
  @SuppressWarnings("unchecked")
public void defaultConfig() {
    JSONObject Blocks = new JSONObject();
    Blocks.put("STONE", Double.valueOf(5.0D));
    this.defaults.put("maxLevels", Integer.valueOf(10));
    JSONObject LevelExemple = new JSONObject();
    JSONArray CommandsArray = new JSONArray();
    JSONArray PermissionsArray = new JSONArray();
    JSONArray LoreArray = new JSONArray();
    LoreArray.add("----");
    LoreArray.add("aaa");
    LoreArray.add("bbb");
    LoreArray.add("----");
    PermissionsArray.add("permission.ici");
    CommandsArray.add("/Commande 1");
    CommandsArray.add("/Commande 2");
    LevelExemple.put("requis", Integer.valueOf(500));
    LevelExemple.put("commandes", CommandsArray);
    LevelExemple.put("permissions", PermissionsArray);
    LevelExemple.put("blocks", Blocks);
    LevelExemple.put("lore", LoreArray);
    this.defaults.put("1", LevelExemple);
  }
  
  public void reload() {
    try {
      if (!this.file.getParentFile().exists())
        this.file.getParentFile().mkdirs(); 
      if (!this.file.exists()) {
        PrintWriter pw = new PrintWriter(this.file, "UTF-8");
        pw.print("{");
        pw.print("}");
        pw.flush();
        pw.close();
        this.json = (JSONObject)this.parser.parse(new InputStreamReader(new FileInputStream(this.file), StandardCharsets.UTF_8));
        defaultConfig();
        save();
      } 
      this.json = (JSONObject)this.parser.parse(new InputStreamReader(new FileInputStream(this.file), StandardCharsets.UTF_8));
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
  }
  
  @SuppressWarnings("unchecked")
public boolean save() {
    try {
      JSONObject toSave = new JSONObject();
      for (String s : this.defaults.keySet()) {
        Object o = this.defaults.get(s);
        if (o instanceof String) {
          toSave.put(s, getString(s));
          continue;
        } 
        if (o instanceof Double) {
          toSave.put(s, Double.valueOf(getDouble(s)));
          continue;
        } 
        if (o instanceof Integer) {
          toSave.put(s, Double.valueOf(getInteger(s)));
          continue;
        } 
        if (o instanceof JSONObject) {
          toSave.put(s, getObject(s));
          continue;
        } 
        if (o instanceof JSONArray)
          toSave.put(s, getArray(s)); 
      } 
      TreeMap<String, Object> treeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
      treeMap.putAll((Map<? extends String, ?>)toSave);
      Gson g = (new GsonBuilder()).setPrettyPrinting().create();
      String prettyJsonString = g.toJson(treeMap);
      FileWriter fw = new FileWriter(this.file);
      fw.write(prettyJsonString);
      fw.flush();
      fw.close();
      return true;
    } catch (Exception ex) {
      ex.printStackTrace();
      return false;
    } 
  }
  
  public String getRawData(String key) {
    return this.json.containsKey(key) ? this.json.get(key).toString() : (
      this.defaults.containsKey(key) ? this.defaults.get(key).toString() : key);
  }
  
  public String getString(String key) {
    return ChatColor.translateAlternateColorCodes('&', getRawData(key));
  }
  
  public boolean getBoolean(String key) {
    return Boolean.valueOf(getRawData(key)).booleanValue();
  }
  
  public double getDouble(String key) {
    try {
      return Double.parseDouble(getRawData(key));
    } catch (Exception exception) {
      return -1.0D;
    } 
  }
  
  public double getInteger(String key) {
    try {
      return Integer.parseInt(getRawData(key));
    } catch (Exception exception) {
      return -1.0D;
    } 
  }
  
  public JSONObject getObject(String key) {
    return this.json.containsKey(key) ? (JSONObject)this.json.get(key) : (
      this.defaults.containsKey(key) ? (JSONObject)this.defaults.get(key) : new JSONObject());
  }
  
  public JSONArray getArray(String key) {
    return this.json.containsKey(key) ? (JSONArray)this.json.get(key) : (
      this.defaults.containsKey(key) ? (JSONArray)this.defaults.get(key) : new JSONArray());
  }
}
