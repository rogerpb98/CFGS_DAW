@extends('layouts.app')

@section('template_title')
    {{ $product->name ?? 'Show Product' }}
@endsection

@section('content')
    <section class="content container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header">
                        <div class="float-left">
                            <span class="card-title">Show Product</span>
                        </div>
                        <div class="float-right">
                            <a class="btn btn-primary" href="{{ route('products.index') }}"> Back</a>
                        </div>
                    </div>

                    <div class="card-body">
                        
                        <div class="form-group">
                            <strong>Img:</strong>
                            {{ $product->img }}
                        </div>
                        <div class="form-group">
                            <strong>Preu:</strong>
                            {{ $product->preu }}
                        </div>
                        <div class="form-group">
                            <strong>Procedencia:</strong>
                            {{ $product->procedencia }}
                        </div>
                        <div class="form-group">
                            <strong>Kcud:</strong>
                            {{ $product->kcud }}
                        </div>
                        <div class="form-group">
                            <strong>Kg100G:</strong>
                            {{ $product->kg100g }}
                        </div>
                        <div class="form-group">
                            <strong>Greixos:</strong>
                            {{ $product->greixos }}
                        </div>
                        <div class="form-group">
                            <strong>Carbohidrats:</strong>
                            {{ $product->carbohidrats }}
                        </div>
                        <div class="form-group">
                            <strong>Proteines:</strong>
                            {{ $product->proteines }}
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
@endsection
