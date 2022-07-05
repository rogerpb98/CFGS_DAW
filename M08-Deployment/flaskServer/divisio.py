from flask import Flask, jsonify
app = Flask(__name__)

@app.route('/<op1>/<op2>')
def divisio(op1, op2):
    n_op1 = float(op1)
    n_op2 = float(op2)
    resultat = {'operador': 'divisio', 'resultat': n_op1 / n_op2}
    return jsonify(resultat), 200

if __name__=='__main__':
    app.run(host='0.0.0.0', port='5002')
