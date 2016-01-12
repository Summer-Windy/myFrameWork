package com.xbb.net.dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * smartbox的检查树
 * @author ryan
 *
 */
public class Tree {

	/**
	 * 头节点
	 */
	private  Node head;
	/**
	 * 单例树
	 */
	private volatile static Tree tree;
	private Tree(){
		head=new Node();
		head.setParents(null);
		head.setChildren(new ArrayList<Node>());
		head.setIsOver(false);
	}
	/**
	 * 获得一棵树
	 * @return
	 */
	public static Tree getTree(){
		if(tree==null){
			synchronized (Tree.class) {
				if(tree==null){
					tree=new Tree();
				}
			}
		}
		tree.resultStrList.clear();//清理掉查询的结果集合
		return tree;
	}
	/**
	 * 增加树枝
	 * @param currentNode 当前节点
	 * @param layer 该比较字符串str下标为layer的
	 * @param str 要加入的字符串
	 */
	public void addBranch(Node currentNode,int layer,String str){
		if(currentNode==null)
			currentNode=this.head;
		
		char[] chars=str.toCharArray();
		for(int z=0;z<chars.length;z++){
			if((chars[z]>='0'&&chars[z]<='9')||(chars[z]>='a'&&chars[z]<='z')||(chars[z]>='A'&&chars[z]<='Z')||chars[z]=='-'||chars[z]=='.'||chars[z]=='+'||chars[z]=='+'){
				
			}else{
				return;
			}
		}
		//获取当前节点的孩子
		List<Node> listChildren=currentNode.getChildren();
		//1、该节点没有孩子
		if(listChildren==null){
			for(int i=layer;i<chars.length;i++){
				Node nodeChild=new Node();
				nodeChild.setWord(chars[i]);
				nodeChild.setChildren(new ArrayList<Node>());
				nodeChild.setIsOver(true);
				
				//建立父结点和孩子结点的关系
				relate(currentNode,nodeChild);
				currentNode=nodeChild;//当次的孩子节点作下一个节点的父亲节点
			}
		}else{
			boolean isExist=false;//该节点有孩子，但是孩子中有没有字符串str下标为layer的字符的 标识
			//检查该节点的孩子是否存在字符串str下标为layer的字符
			Node node=null;//如果该节点的孩子存在字符串str下标为layer的字符，则把该节点保留到node变量中
			for(int i=0;i<listChildren.size();i++){
				if(listChildren.get(i).getWord()==chars[layer]){
					isExist=true;
					node=listChildren.get(i);
					break;
				}
			}
			//2、有存在
			if(isExist){
				addBranch(node,++layer,str);
			}
			//3、没有存在
			else{
				for(int i=layer;i<chars.length;i++){
					Node nodeChild=new Node();
					nodeChild.setWord(chars[i]);
					nodeChild.setChildren(new ArrayList<Node>());
					nodeChild.setIsOver(true);
					
					//建立父结点和孩子结点的关系
					relate(currentNode,nodeChild);
					currentNode=nodeChild;//当次的孩子节点作下一个节点的父亲节点
				}
			}
			
		}
	}

	
	
	/**
	 * 父亲节点和子结点进行关联
	 * @param parentNode 父亲节点
	 * @param childNode 子结点
	 */
	private void relate(Node parentNode,Node childNode){
		parentNode.addChild(childNode);
		parentNode.setIsOver(false);
		childNode.setParents(parentNode);
	}
	
	List<String> resultStrList=new ArrayList<String>();
	/**
	 * 根据残缺字符串查询树中的所有可能字符串
	 * @param currentNode 要查询的首节点
	 * @param layer 当前到第几层，即到要查询的字符的第几位
	 * @param str 要查询的残缺字符串
	 * @param num 要查询的数目
	 * @return
	 */
	public List<String> select(Node currentNode,int layer,String str,Integer num)	{
		if(currentNode==null)
			currentNode=this.head;
		
		if(num==null){
			num=10;
		}
		
		char[] chars=str.toCharArray();
		//获取当前节点的孩子
		List<Node> listChildren=currentNode.getChildren();
		//1、该节点没有孩子
		if(listChildren==null){
			return null;
		}else{
			boolean isExist=false;//该节点有孩子，但是孩子中有没有字符串str下标为layer的字符的 标识
			//检查该节点的孩子是否存在字符串str下标为layer的字符
			Node node=null;//如果该节点的孩子存在字符串str下标为layer的字符，则把该节点保留到node变量中
			for(int i=0;i<listChildren.size();i++){
				if(layer<chars.length&&listChildren.get(i).getWord()==chars[layer]){
					isExist=true;
					node=listChildren.get(i);
//					preSb.append(node.getWord());//把匹配到的前缀放入preSb变量中
					break;
				}
			}
			//2、有存在
			if(isExist){
				select(node,++layer,str,num);
			}
			//3、没有存在
			else{
				
				Node tempNode=currentNode;
				//设置标志
				LinkedList<Mark> linkedList=new LinkedList<Mark>();
				Mark mark=new Mark();
				mark.setOverNum(0);
				mark.setAllNum(tempNode.getChildren().size());
				linkedList.add(mark);
				
				StringBuilder sb=new StringBuilder();
				while(resultStrList.size()<=num){
					Mark mark4=linkedList.getLast();
					while(mark4.getOverNum()==mark4.getAllNum())
					{
						tempNode=tempNode.getParents();
						linkedList.removeLast();
						if(sb.length()!=0)
							sb.deleteCharAt(sb.length()-1);
						if(linkedList.isEmpty())
							return resultStrList;
						else
							mark4=linkedList.getLast();
					}
					
					while(!tempNode.getIsOver()){//不是叶子节点，当前节点一定有孩子
						Mark mark1=linkedList.getLast();
						sb.append(tempNode.getChildren().get(mark1.getOverNum()).getWord());//当前节点还未访问过的孩子
						tempNode=tempNode.getChildren().get(mark1.getOverNum());//把刚刚访问过的孩子节点设置成当前节点
						mark1.setOverNum(mark1.getOverNum()+1);//标识访问过的孩子数加1
						
						
						if(!tempNode.getIsOver()){//如果此时的tempNode不是叶子节点，则把Mark纪录类记录下此刻的节点的访问情况
							Mark mark2=new Mark();
							mark2.setOverNum(0);
							mark2.setAllNum(tempNode.getChildren().size());
							linkedList.add(mark2);
						}
					}
//					resultStrList.add(str+sb.toString());//完成一条结果的查询
					resultStrList.add(str.substring(0, layer)+sb.toString());//完成一条结果的查询
					
					//程序执行到这一步，说明tempNode一定是叶子节点，要在循环，则把tempNode设置成其父节点
					Mark mark3=linkedList.getLast();
					if(mark3.getAllNum()==mark3.getOverNum()){//判断tempNode是否是最后一个孩子
						linkedList.removeLast();
						if(!linkedList.isEmpty()){
							tempNode=tempNode.getParents().getParents();//tempNode是最后一个孩子，而且父亲还有父亲
							sb.deleteCharAt(sb.length()-1);
							sb.deleteCharAt(sb.length()-1);
						}else{
							break;//所有可能的结果足够10条了，退出
						}
					}else{
						tempNode=tempNode.getParents();
						sb.deleteCharAt(sb.length()-1);
					}
					//程序走到这一步，说明tempNode一定是非叶子节点
				}
				
			}
			
		}
		return resultStrList;
	}
	
	/**
	 * 添加字符串到树中
	 * @param str
	 */
	public void add(String str){
		addBranch(null, 0, str);
	}
			
	/**
	 * 根据已有的字符串片段从树中查询出全部的字符
	 * @param str
	 * @return
	 */
	public List<String> select(String str,Integer num){
		return select(null, 0, str,num);
	}
}

/**
 * 非叶子节点的访问记录类
 * @author ryan
 *
 */
class Mark{
	/**
	 * 访问过多少个孩子
	 */
	private int overNum;
	/**
	 * 总的有多少个孩子
	 */
	private int allNum;
	/**
	 * 获取访问过多少个孩子的数目
	 * @return
	 */
	public int getOverNum() {
		return overNum;
	}
	/**
	 * 设置访问过多少个孩子的数目
	 * @param overNum
	 */
	public void setOverNum(int overNum) {
		this.overNum = overNum;
	}
	/**
	 * 获取总的有多少个孩子
	 * @return
	 */
	public int getAllNum() {
		return allNum;
	}
	/**
	 * 设置该节点有多少个孩子
	 * @param allNum
	 */
	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}
	
}