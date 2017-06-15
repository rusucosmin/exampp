/**
 * Created by cosmin on 13/06/2017.
 */
import {Http, Response, Headers} from "@angular/http";
import {Observable} from "rxjs";
import {Pizza} from "./pizza.model";

import 'rxjs/add/operator/catch';

import 'rxjs/add/operator/map';
import {Injectable} from "@angular/core";

/**
 * Created by cosmin on 12/06/2017.
 */
@Injectable()
export class PizzaService {
  private pizzasUrl = 'http://localhost:8080/api/pizzas';
  private pizzasFilterUrl = 'http://localhost:8080/api/pizzas-filter';
  private headers = new Headers({"Content-Type": "application/json"});

  constructor(private http: Http) {}

  getPizza(): Observable<Pizza[]> {
    console.log("getting pizzas...");
    return this.http.get(this.pizzasUrl)
      .map(this.extractData)
      .catch(this.handleError);
  }

  savePizza(pizza: Pizza) {
    console.log("saving pizza...");
    console.log(JSON.stringify({"pizza": pizza}));
    return this.http.post(this.pizzasUrl, JSON.stringify({"pizza": pizza}), { headers: this.headers })
      .map(this.extractData)
      .catch(this.handleError);
  }

  filterPizza(body: Object) {
    console.log("request filter");
    console.log(JSON.stringify(body));
    return this.http.post(this.pizzasFilterUrl, JSON.stringify(body), {headers: this.headers})
      .map(this.extractData)
      .catch(this.handleError);
  }

  private extractData(res: Response) {
    let body = res.json();
    console.log("extractData: " + body);
    return body.pizzas || {};
  }
  private handleError(error: Response | any) {
    console.log("handleError: " + error);
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
