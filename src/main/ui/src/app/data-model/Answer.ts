import { Question } from "./Question";

export interface Answer {
	id: number;
	value: string;
	selectionCount: number;
	questionId: Question;
}