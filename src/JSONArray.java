package src;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Authors: Livia Stein Freitas, Christina Vu, and Joyce Gill JSON arrays.
 */
public class JSONArray implements JSONValue {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The underlying array.
   */
  ArrayList<JSONValue> values;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new array.
   */
  public JSONArray() {
    this.values = new ArrayList<JSONValue>();
  } // JSONArray()

  // +-------------------------+-------------------------------------
  // | Standard object methods |
  // +-------------------------+

  /**
   * Convert to a string (e.g., for printing).
   */
  public String toString() {
    String result = "[";
    result = result.concat(this.toStringLoop());
    return result.concat("]");
  } // toString()

  /**
   * Compare to another object.
   */
  public boolean equals(Object other) {
    if (other instanceof JSONArray) {
      JSONArray anotherArray = (JSONArray) other;
      if (this.values.equals(anotherArray.values)) {
        return true;
      }
    } // if(other instanceof JSONValue)
    return false;
  } // equals(Object)

  /**
   * Compute the hash code.
   */
  public int hashCode() {
    return this.values.hashCode();
  } // hashCode()

  // +--------------------+------------------------------------------
  // | Additional methods |
  // +--------------------+

  /**
   * Write the value as JSON.
   */
  public void writeJSON(PrintWriter pen) {
    pen.write(this.toString());
  } // writeJSON(PrintWriter)

  /**
   * Get the underlying value.
   */
  public ArrayList<JSONValue> getValue() {
    return this.values;
  } // getValue()

  // +---------------+-----------------------------------------------
  // | Array methods |
  // +---------------+

  /**
   * Add a value to the end of the array.
   */
  public void add(JSONValue value) {
    this.values.add(value);
  } // add(JSONValue)

  /**
   * Get the value at a particular index.
   */
  public JSONValue get(int index) throws IndexOutOfBoundsException {
    return this.values.get(index);
  } // get(int)

  /**
   * Get the iterator for the elements.
   */
  public Iterator<JSONValue> iterator() {
    return this.values.iterator();
  } // iterator()

  /**
   * Set the value at a particular index.
   */
  public void set(int index, JSONValue value) throws IndexOutOfBoundsException {
    this.values.set(index, value);
  } // set(int, JSONValue)

  /**
   * Determine how many values are in the array.
   */
  public int size() {
    return this.values.size();
  } // size()

  /* HELPERS */
  public String toStringLoop() {
    String body = "";
    // edge case: first element of the array
    body = body.concat(this.values.get(0).toString());
    for (int i = 1; i < this.values.size(); i++) {
      body = body.concat(", " + this.values.get(i));
    } // for
    return body;
  }// toStringLoop()

} // class JSONArray
