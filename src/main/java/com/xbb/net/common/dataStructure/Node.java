package com.xbb.net.common.dataStructure;

import java.util.List;

/**
 * 节点
 * @author ryan
 *
 */
public class Node {

	/**
	 * 节点的关键字
	 */
	private char word;
	/**
	 * 父节点引用
	 */
	private Node parents;
	/**
	 * 孩子结点引用列表
	 */
	private List<Node> children;
	/**
	 * 是否是叶子节点
	 */
	private Boolean isOver;
	/**
	 * 节点的关键字
	 * @return
	 */
	public char getWord() {
		return word;
	}
	/**
	 * 节点的关键字
	 * @param word
	 */
	public void setWord(char word) {
		this.word = word;
	}
	/**
	 * 父节点引用
	 * @return
	 */
	public Node getParents() {
		return parents;
	}
	/**
	 * 父节点引用
	 * @param parents
	 */
	public void setParents(Node parents) {
		this.parents = parents;
	}
	/**
	 * 孩子节点引用列表
	 * @return
	 */
	public List<Node> getChildren() {
		return children;
	}
	/**
	 * 孩子节点引用列表
	 * @param children
	 */
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	/**
	 * 是否是叶子结点
	 * @return
	 */
	public Boolean getIsOver() {
		return isOver;
	}
	/**
	 * 是否是叶子节点
	 * @param isOver
	 */
	public void setIsOver(Boolean isOver) {
		this.isOver = isOver;
	}
	/**
	 * 添加孩子结点
	 * @param node
	 */
	public void addChild(Node node){
		this.children.add(node);
	}
}