/**
 * 
 */
package controller;



/**
 * @author lonovo
 *
 */
public interface IModel {
	public void setObserver(IObserver o);
	public void notifyObserver();
	public void getoutput();
}
