import { Question } from "./Question";

export interface Survey {
	id: number;
	title: string;
	questionSet: Set<Question>;
}