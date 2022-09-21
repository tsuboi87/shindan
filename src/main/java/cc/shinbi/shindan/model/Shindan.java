package cc.shinbi.shindan.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Shindan {
	private List<Result> results;
	private List<Question> questions;
	
	private Shindan() {
		this.results = new ArrayList<Result>();
		this.questions = new ArrayList<Question>();
	}
	
	public List<Result> getResults() {
		return results;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void shuffle() {
		for(Question question : this.questions) {
			question.shuffle();
		}
		Collections.shuffle(this.questions);
	}
	
	private static List<Result> getResultList() {
		Result[] results = {
			new Result(
					"A型",
					"あなたはA型に近い性格をしています"
			),
			new Result(
					"B型",
					"あなたはB型に近い性格をしています"
			),
			new Result(
					"O型",
					"あなたはO型に近い性格をしています"
			),
			new Result(
					"AB型",
					"あなたはAB型に近い性格をしています"
			),
		};
		List<Result> list = Arrays.asList(results);
		return list;
	}
	
	private static List<Question> getQuestionList() {
		List<Question> list = new ArrayList<Question>();
		 
		
		Question question1 = new Question("q1","自己紹介でやりがちな行動");
		question1.addItem(0,"とにかく愛想笑い！「無難に」がモットー");
		question1.addItem(1,"アピール無し、愛嬌も無し");
		question1.addItem(2,"個性・インパクトで猛烈アピール！");
		question1.addItem(3,"よそよそしさ全開！名乗って即終了！？");
		list.add(question1);
		
		Question question2 = new Question("q2","休みの日は何をしますか？");
		question2.addItem(0,"分単位で予定を立てて外れてしまう。");
		question2.addItem(1,"気分に任せて適当に過ごす。");
		question2.addItem(2,"必ず友達と一緒に出かける");
		question2.addItem(3,"あれこれ考えるがなにもできずに終わる");
		list.add(question2);
		
		Question question3 = new Question("q3","どんな時にストレスを感じますか？");
		question3.addItem(0,"対人関係で自分を抑えすぎる");
		question3.addItem(1,"自由や変化のない生活は苦行");
		question3.addItem(2,"目標が達成されないとストレス増");
		question3.addItem(3,"一人の時間がとれないとしんどい");
		list.add(question3);
		
		Question question4 = new Question("q4","4月1日はエイプリルフールあなたはどんなウソを用意していますか？");
		question4.addItem(0,"一応ウソを用意する");
		question4.addItem(1,"とっさにひねり出すウソが天才的");
		question4.addItem(2,"オモシロ系ウソで話題の中心に");
		question4.addItem(3,"バカにしている");
		list.add(question4);
		
		Question question5 = new Question("q5","苦手なことは？");
		question5.addItem(0,"ハメ外してバカ騒ぎ");
		question5.addItem(1,"長時間じっとしている");
		question5.addItem(2,"一人で食事をする");
		question5.addItem(3,"集団行動");
		list.add(question5);
		
		return list;
	}
	
	public static Shindan createShindan() {
		Shindan shindan = new Shindan();
		
		List<Result> results = getResultList();
		shindan.getResults().addAll(results);
		
		List<Question> questions =  getQuestionList();
		shindan.getQuestions().addAll(questions);
		
		shindan.shuffle();
		return shindan;
	}
	
	public Result check(List<Integer> answers) {
		int[] counters = new int[this.results.size()];
		Arrays.fill(counters, 0);
		
		for(Integer index : answers) {
			counters[index]++;
		}
		
		int index = 0;
		int maxCount = 0;
		for(int i = 0; i < counters.length; i++) {
			int counter = counters[i];
			if (counter > maxCount) {
				index = i;
				maxCount = counter;
			}
		}
		
		return this.results.get(index);
	}

}
