import { ApexChart } from "ng-apexcharts";

export interface Visual {
	question: string;
	options: ApexChart;
	labels: string[];
	series: number[];
}