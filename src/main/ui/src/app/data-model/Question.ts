import { Answer } from "./Answer";
import { Survey } from "./Survey";

export interface Question {
	id: number;
	value: string;
	answerSet: Set<Answer>;
	surveyId: Survey;
}