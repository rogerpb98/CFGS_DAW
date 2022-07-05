<?php

namespace App\Http\Controllers;

use App\Models\Product;
use Illuminate\Http\Request;

/**
 * Class ProductController
 * @package App\Http\Controllers
 */
class ProductController extends Controller
{
    public function allProducts() {
        $products = \DB::table('products')->get();
        // return view('/shop')->with('products', $products);
       // echo $products;
        return view('shop', array('products'=>$products));
    }

    public function singleProduct(Request $request) {
        $products = \DB::table('products')->where('id', $request->id)->first();
        $item = array();
        $item['id'] = $products->id;
        $item['img'] = $products->img;
        $item['preu'] = $products->preu;
        $item['procedencia'] = $products->procedencia;
        $item['kcud'] = $products->kcud;
        $item['kg100g'] = $products->kg100g;
        $item['greixos'] = $products->greixos;
        $item['carbohidrats'] = $products->carbohidrats;
        $item['proteines'] = $products->proteines;
        $product =  json_encode($item);
        return view('detail', array('product'=>json_decode($product)));
        //echo $product;
      //  echo json_encode($item);
    }

    public function buyProduct(Request $request) {
        Product::where('id', $request->id)
            ->update([
            'bought'=> \DB::raw('bought+1'),
        ]);
        return view('soldIt');
    }
}
