package hdss.io;

import java.util.Date;

public class ScenarioPublicData {

	private String watershedName;
	private Date scenarioEvaluationDate;
	private String evaluationScope;
	private String scenarioEvaluation;
	
	public ScenarioPublicData (String name, Date evaluationDate, String scope, String evaluation)
	{
		watershedName = name;
		scenarioEvaluationDate = evaluationDate;
		evaluationScope = scope;
		scenarioEvaluation = evaluation;
	}
	
	public String getWatershedName() {
		return watershedName;
	}

	public Date getScenarioEvaluationDate() {
		return scenarioEvaluationDate;
	}

	public String getEvaluationScope() {
		return evaluationScope;
	}

	public String getScenarioEvaluation() {
		return scenarioEvaluation;
	}	
}
